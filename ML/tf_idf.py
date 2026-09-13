class TFIDF(object):

    def __init__(self, corpus):
        self.corpus = corpus
        self.vocab = []
        self.punctuation_marks = {
            ".", "?", "!", ",", ":", ";", "-", "—", "–", 
            "(", ")", "[", "]", "{", "}", "'", '"', "..."
        }
        self.tf_matrix = []
        self.idf_scores = []
        self.word_doc_count = {}
        self.preprocess()

    def preprocess(self):
        vocab_set = set()
        for doc in self.corpus:
            for word in doc.split():
                word_clean = self.clean_word(word)
                if word_clean and word_clean not in self.punctuation_marks and word_clean not in vocab_set:
                    vocab_set.add(word_clean)
        sorted_vocab = sorted(vocab_set)
        self.vocab = sorted_vocab

    def clean_word(self, word):
        """Helper function to lowercase and strip punctuation from word edges"""
        word = word.lower()
        # Strip trailing/leading punctuation (e.g., "fun!" -> "fun")
        return word.strip("".join(self.punctuation_marks))

    def tf(self):
        # doc1 -> [w1, w2, w3]
        # doc2 -> [w1, w2, w3]
        for doc in self.corpus:
            count = {}

            cleaned_words = []

            for word in doc.split():
                # word cleaning
                cleaned_word = self.clean_word(word)
                if cleaned_word and cleaned_word not in self.punctuation_marks:
                    cleaned_words.append(cleaned_word)

            word_count = len(cleaned_words)

            for word in cleaned_words:
                # Need to count the number of documents the word appears at least once
                if word not in count and word not in self.punctuation_marks:
                    self.word_doc_count[word] = self.word_doc_count.get(word, 0 ) + 1
                if word not in self.punctuation_marks:
                    count[word] = count.get(word, 0) + 1

            # Now calculate for each words
            tf_for_doc = []
            for w in self.vocab:
                tf = count.get(w, 0) / word_count
                tf_for_doc.append(tf)
            self.tf_matrix.append(tf_for_doc)

    def idf(self):
        import math
        # ln(N/DF)+1
        # for each word in the vocab,
        # count how many docs contain the word at least once
        n = len(self.corpus)
        for word in self.vocab:
            if word not in self.punctuation_marks:
                df = self.word_doc_count[word]
                idf_score = math.log(n/df) + 1 if df > 0 else 0
                self.idf_scores.append(idf_score)

    def tfidf(self):
        self.tf()
        self.idf()
        # Now lets calculate the tf_idf, tf_matrix becomes the tf_idf matrix
        for i in range(len(self.tf_matrix)):
            row = self.tf_matrix[i]
            for j in range (len(row)):
                tf = self.tf_matrix[i][j]
                idf = self.idf_scores[j]
                tf_idf = tf * idf
                self.tf_matrix[i][j] = tf_idf
        self.visualize(self.tf_matrix)
                
    def visualize(self, matrix):
        import pandas as pd
        # 1. Create row labels
        doc_labels = [f"Doc {idx + 1}" for idx in range(len(matrix))]
        # 2. Convert the matrix to a DataFrame using global vocabulary as columns
        df = pd.DataFrame(matrix, index=doc_labels, columns=self.vocab)
        # 3. Round the values inside the DataFrame to x decimal places for clean viewing
        df_rounded = df.round(5)
        # 4. Print the formatted table
        print(df_rounded.to_string())

if __name__ == "__main__":
    corpus = ""
    corpus = [
        "Data science is fun",               #  Document 1
        "Data science uses data",            #  Document 2
        "Science is logic",                  #  Document 3
    ]
    tf_idf = TFIDF(corpus)
    tf_idf.tfidf()


