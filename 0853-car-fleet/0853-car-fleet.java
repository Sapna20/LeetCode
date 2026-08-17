class Car {
    int position;
    double time;

    Car(int pos, double t) {
        position = pos;
        time = t;
    }

    public int getPosition() {
        return this.position;
    }

    public double getTime() {
        return this.time;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for(int i=0; i<n; i++) {
            double time = (double)(target - position[i])/(double)speed[i];
            cars[i] = new Car(position[i], time);
        }
        Arrays.sort(cars, (a, b) -> (a.getPosition() - b.getPosition()));

        Stack<Car> stack = new Stack<Car>();
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty() || cars[i].getTime() > stack.peek().getTime()) {
                stack.push(cars[i]);
            }
        }

        return stack.size();
    }
}