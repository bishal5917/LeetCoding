class Solution(object):
    def searchRange(self, nums, target):
        ans = []
        x = self.returnIdx(nums, target, True)
        y = self.returnIdx(nums, target, False)
        ans.append(x)
        ans.append(y)
        return ans

    def returnIdx(self, nums, target, leftOne):
        l, r = 0, len(nums) - 1
        i = -1

        while l <= r:
            m = (l + r) // 2
            if nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
            else:
                i = m
                if leftOne:
                    r = m - 1
                else:
                    l = m + 1

        return i


if __name__ == "__main__":
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    obj = Solution()
    print(obj.searchRange(nums, target))
