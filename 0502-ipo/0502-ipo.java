class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();
        int n = capital.length;
        for(int i=0; i<n; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }

        Collections.sort(projects, (a, b) -> a.capital - b.capital);
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a, b) -> (b - a));

        int j=0;
        for(int i=0; i<k; i++) {
            while(j<n) {
                if(projects.get(j).capital <= w){
                    maxProfits.add(projects.get(j).profit);
                    j++;
                } else {
                    break;
                }
                
            }

            if(maxProfits.isEmpty())
                return w;

            w += maxProfits.poll();
        }

        return w;
    }
}

class Project {
    int profit;
    int capital;

    Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}