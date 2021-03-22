fun main() {
    // write your code here
        val nums = IntArray(3) { readLine()!!.toInt() }

        print(nums[0] in nums[1]..nums[2])
}