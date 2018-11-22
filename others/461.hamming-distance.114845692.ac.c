int hammingDistance(int x, int y) {
    int t = x ^ y;
    int count = 0;
    while (t > 0) {
        if ((t % 2) == 1)   count++;
        t = t/2;
    }
    return count;
}
