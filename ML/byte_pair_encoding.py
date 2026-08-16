class BPE(object):

    def __init__(self, text):
        self.text = text
        self.tokens = text.encode('utf-8')

        self.tokens = list(map(int, self.tokens))

        self.vocab_size = 276
        self.num_merges = self.vocab_size - 256
        self.bpe()


    def get_count(self, token_ids):
        counts = {}
        for pair in zip(token_ids, token_ids[1:]):
            # print(pair)
            counts[pair] = counts.get(pair,0) + 1
        # print(counts)
        # common_pair_list = sorted(((v,k) for k,v in counts.items()), reverse=True)
        # print(common_pair_list)
        # print(f"{chr(101)} = 101 and {chr(32)} = 32")
        # get the top pair
        # top_pair = max(counts, key = counts.get)
        # print(top_pair)
        # print(self.merge([1, 3, 3, 4, 10, 20] , (3,4), 256))
        # token2 = self.merge(self.tokens, top_pair, 256)
        # print(token2)
        # print(len(token2))
        return counts


    def merge(self, ids, pair, idx):
        """
        And how long to do this for ?
        Well this depends upon us as a hyperparameter
        The more we do this...
        The larger will be our vocabulary
        And shorter will be our sequence length
        """
        newids = []
        i = 0
        while i<len(ids):
            if i < len(ids) -1 and ids[i] == pair[0] and ids[i+1] == pair[1]:
                newids.append(idx)
                i+=2
            else:
                newids.append(ids[i])
                i += 1

        return newids

    def bpe(self):
        ids = self.tokens
        self.merges = {}
        for i in range(self.num_merges):
            stats = self.get_count(ids)
            if not stats:
                break
            top_pair = max(stats, key = stats.get)
            idx = 256 + i
            print(f"Merging pair {top_pair} into a new token {idx}")
            ids = self.merge(ids, top_pair, idx)
            self.merges[top_pair] = idx

        # print(merges)


        # Calculation of compression ratio to see what we acheived
        print(f"TEXT  LENGTH = {len(self.text)}")
        print(f"TOKENS LENGTH = {len(self.tokens)}")
        print(f"IDs LENGTH = {len(ids)}")
        print(f"Compression ratio = {len(self.tokens)/ len(ids):.2f}")


    def encode(self, text):
        tokens = list(text.encode("utf-8"))
        print(tokens)
        while len(tokens) >= 2:
            counts = self.get_count(tokens)
            """
            Among all the pairs currently present in the text,
            find the pair that was learned earliest by BPE.
            """
            pair = min(counts, key = lambda p : self.merges.get(p, float("inf")))
            # print(pair)
            if pair not in self.merges:
                break
            idx = self.merges[pair]
            tokens = self.merge(tokens, pair, idx)

        return tokens
    

    def decode(self, ids):
        # Given a sequence of integers in the range (0, vocab_size), what is the text ?
        vocab = {idx : bytes([idx]) for idx in range (256)}
        # print(self.merges)
        for (p0, p1), idx in self.merges.items():
            vocab[idx] = vocab[p0] + vocab[p1]
        # print(vocab)

        # Given ids - list of integers, return token string
        tokens = b"".join(vocab[idx] for idx in ids)
        text = tokens.decode('utf-8', errors='replace')
        return text


if __name__ == "__main__":
    training_text = ""

    with open("ML/tinyshakespeare.txt", "r", encoding="utf-8") as f:
        training_text = f.read()

    # training_text = "Ｕｎｉｃｏｄｅ! 🅤🅝🅘🅒🅞🅓🅔‽ 🇺‌🇳‌🇮‌🇨‌🇴‌🇩‌🇪! 😄 The very name strikes fear and awe into the hearts of programmers worldwide. We all know we ought to “support Unicode” in our software (whatever that means—like using wchar_t for all the strings, right?). But Unicode can be abstruse, and diving into the thousand-page Unicode Standard plus its dozens of supplementary annexes, reports, and notes can be more than a little intimidating. I don’t blame programmers for still finding the whole thing mysterious, even 30 years after Unicode’s inception."

    bpe = BPE(training_text)
    print(bpe.encode("Hello world!"))
    # print(bpe.decode(bpe.encode("Hello world!")))

