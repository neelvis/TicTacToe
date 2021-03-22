fun main() {
    // write your code here
        val nums = IntArray(5) { readLine()!!.toInt() }

        print(nums[4] in nums[0]..nums[1] && nums[4] in nums[2]..nums[3])
}