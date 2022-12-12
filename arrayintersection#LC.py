def intersect(nums1, nums2):
    final = []
    i, j = 0, 0
    nums1.sort()
    nums2.sort()

    while i < len(nums1) and j < len(nums2):
        if nums1[i] == nums2[j]:
            final.append(nums1[i])
            i += 1
            j += 1
        elif nums1[i] < nums2[j]:
            i += 1
        elif nums1[i] > nums2[j]:
            j += 1

    return final


if __name__ == "__main__":
    # nums1 = [1, 2, 2, 1]
    # nums2 = [2, 2]
    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    print(intersect(nums1, nums2))
