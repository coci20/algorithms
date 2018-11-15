func lemonadeChange(bills []int) bool {
    countFive := 0
    countTen := 0
    countTwenty := 0
    for i := 0; i < len(bills); i++{
        getMoney := bills[i]
        switch getMoney{
        case 5: // if get 5 no change to return
            countFive++
        case 10:    // if get 10, need a 5
            countTen++
            if countFive == 0 {
                return false
            }
            countFive-- // give a 5 away
        case 20:    // if get 20, can do with 3 fives, 1 ten and 1 fives
            countTwenty++
            if countFive-3 < 0 && (countTen-1 < 0 || countFive-1 < 0) {
                return false
            }
            if countTen-1 >= 0 && countFive-1 >= 0{
                countTen--
                countFive -= 1
            } else {
                countFive -= 3
            }
        }
    }
    return true
}
