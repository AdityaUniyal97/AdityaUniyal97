class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = {}
        for ch in t:
            if ch in need:
                need[ch] += 1
            else:
                need[ch] = 1
        missing = len(t)
        l = 0
        ans = ""
        for r in range(len(s)):
            if s[r] in need and need[s[r]] > 0:
                missing -= 1
            if s[r] in need:
                need[s[r]] -= 1
            while missing == 0:
                if ans == "" or r - l + 1 < len(ans):
                    ans = s[l:r + 1]
                if s[l] in need:
                    need[s[l]] += 1
                    if need[s[l]] > 0:
                        missing += 1
                l+=1
        return ans