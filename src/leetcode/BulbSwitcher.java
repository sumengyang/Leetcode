package leetcode;

/* There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example:
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 */
public class BulbSwitcher {

	public int bulbSwitch(int n) {
		return (int) Math.sqrt((double) n);
	}
	
	//TIME LIMIT EXCEEDED
	 public int bulbSwitch2(int n) {
	        boolean[] bulbs = new boolean[n];
	        for(int i = 0; i < n; i++)
	            bulbs[i] = false;
	            
	        for(int i = 1; i <= n; i++){
	            for(int j = 0; j < n; j++){
	                if((j+1)%i == 0)
	                    bulbs[j] = !bulbs[j];
	            }
	        }
	        int result = 0;
	        for(int i = 0; i < n; i++)
	            if(bulbs[i])
	                result += 1;
	                
	        return result;
	    }
}
