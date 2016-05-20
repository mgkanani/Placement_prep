/*
Gas Station

 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique. 
*/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,temp;
        for(int i=0;i<gas.length;i++){
            total += gas[i] - cost[i];
        }
        if(total<0)
            return -1;
        int i=0;
        while(i<gas.length){
            temp = check(gas,cost,i,0);
            if(temp>=0)
                return i;
            while(temp<0){
                temp += cost[i] - gas[i];
                i++;
            }
        }
        return -1;
    }
    public int check(int[] gas, int[] cost, int start, int temp){
        if(start==gas.length)
            return 0;
        if(temp<0)
            return temp;
        return check(gas,cost,start+1,temp+gas[start]-cost[start]);
            
    }
}