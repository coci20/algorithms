func subdomainVisits(cpdomains []string) []string {
    m := make(map[string]int)
    for _, v := range cpdomains {
        strs := strings.Split(v, " ")
        nums, _ := strconv.Atoi(strs[0])
        dom := strs[1]
        if _, ok := m[dom]; !ok {
            m[dom] = nums
        } else {
            m[dom] += nums
        }
        var ids []int
        runes := []rune(dom)
        for i, r := range runes{
            if r == '.' {
                ids = append(ids, i)
            }
        }
        for _, i := range ids{
            subs := string(runes[i+1:])
            if _, ok := m[subs]; !ok {
                m[subs] = nums
            } else {
                m[subs] += nums
            }
        }
    }
    var res []string
    for k, v := range m {
        res = append(res, strconv.Itoa(v) + " " + k)
    }
    return res
}
