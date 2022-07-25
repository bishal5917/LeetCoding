d_out = {
    'A': ["B", "C"],
    'C': ["A"],
    'B': ["C"],

}

d_in = {
    'A': ["C"],
    'C': ["A", "B"],
    'B': ["A"]
}

pr = {
    "A": 1,
    "B": 1,
    "C": 1
}

c = {
    "A": 2,
    "B": 1,
    "C": 1
}

d = 0.85

it_count = 0
while it_count != 1:
    pr_in_a = d_in["A"]
    pra = 0.15
    for item in pr_in_a:
        pra = pra + d*(pr[item]/c[item])
    pr['A'] = pra

    pr_in_b = d_in["B"]
    prb = (1-d)
    for item in pr_in_b:
        prb = prb + d*(pr[item]/c[item])
    pr['B'] = prb

    pr_in_c = d_in["C"]
    prc = (1-d)
    for item in pr_in_c:
        prc = prc + d*(pr[item]/c[item])
    pr['C'] = prc

    it_count += 1

print(pr)
