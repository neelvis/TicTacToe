fun main() {
    // write your code here
    val count = readLine()!!.toInt()

    var longestSubsequence = 1
    var tempLongestSubsequence = 1
    val sequence = Array<Int>(count) { readLine()!!.toInt() }

    for (i in 1 until count)
        if (sequence[i] >= sequence[i - 1]) {
            tempLongestSubsequence++
        } else {
            if (longestSubsequence < tempLongestSubsequence) {
                longestSubsequence = tempLongestSubsequence
            }
            tempLongestSubsequence = 1
        }
    if (longestSubsequence < tempLongestSubsequence) {
        longestSubsequence = tempLongestSubsequence
    }
    print(longestSubsequence)
}