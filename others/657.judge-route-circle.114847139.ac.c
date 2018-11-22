bool judgeCircle(char* moves) {
    int x = 0, y = 0;
    while(*moves != '\0') {
        switch(*moves) {
            case 'L': 
                x = x - 1;
                break;
            case 'R':
                x = x + 1;
                break;
            case 'D':
                y = y - 1;
                break;
            case 'U':
                y = y + 1;
                break;
        }
        moves++;
    }
    if (x == 0 && y ==0) return true;
    return false;
}
