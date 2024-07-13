class Robot {
    public int position, health, index;
    public char direction;

    public Robot(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}

class Solution {
    Stack<Robot> s;

    private void makeCollisions(Robot robot) {
        // current robot will collide with every robot in stack that is going right
        while (!s.isEmpty() && s.peek().direction == 'R' && s.peek().health < robot.health) {
            // current robot wins
            s.pop();
            robot.health--;
        }
        if (!s.isEmpty() && s.peek().direction == 'R') { // current robot loses
            if (s.peek().health == robot.health) {
                // last collision was with a robot of same health, both removed
                s.pop();
            } else {
                // last collision was with a robot of bigger health, it wins
                s.peek().health--;
            }
        } else {
            // current robot wins from every robot going right
            // it continues going left towards -infinity
            s.push(robot);
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        // sort by initial position
        Collections.sort(robots, (r1, r2) -> r1.position - r2.position);
        s = new Stack<>();
        for (Robot robot : robots) {
            if (robot.direction == 'R') { // going right
                s.push(robot);
            } else { // going left
                makeCollisions(robot);
            }
        }
        robots.clear();
        while (!s.isEmpty()) {
            robots.add(s.pop());
        }
        // sort by initial index
        Collections.sort(robots, (r1, r2) -> r1.index - r2.index);
        List<Integer> result = new ArrayList<>();
        for (Robot robot : robots) {
            result.add(robot.health);
        }
        return result;
    }
}