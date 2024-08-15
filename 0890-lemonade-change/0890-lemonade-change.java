class Solution {
    public boolean lemonadeChange(int[] bills) {
        Stack <Integer> s5 = new Stack<>();
        Stack <Integer> s10 = new Stack<>();

        if(bills[0] != 5) {
            return false;
        }
        else {
            s5.push(bills[0]);
        }

        for(int i = 1; i < bills.length; i++) {
            if(bills[i] == 5) {
                s5.push(bills[i]);
            }
            else if(bills[i] == 10) {
                s10.push(bills[i]);
                if(!s5.isEmpty()) {
                    s5.pop();
                }
                else return false;
            }
            else if(bills[i] == 20) {
                if(!s10.isEmpty()) {
                    s10.pop();
                    if(!s5.isEmpty()) {
                        s5.pop();
                    }
                    else return false;
                }
                else if(!s5.isEmpty()) {
                    for(int j = 0; j < 3; j++) {
                        if(!s5.isEmpty()) {
                            s5.pop();
                        }
                        else return false;
                    }
                }
                else return false;
            }
        }
        return true;
    }
}