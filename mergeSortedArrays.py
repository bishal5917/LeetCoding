def merge(nums1, m, nums2, n):

    i = m
    j = 0

    while i < len(nums1):
        nums1[i] = nums2[j]
        i += 1
        j += 1

    nums1.sort()
    return nums1


if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]
    m = 3
    n = 3
    print(merge(nums1, m, nums2, n))
