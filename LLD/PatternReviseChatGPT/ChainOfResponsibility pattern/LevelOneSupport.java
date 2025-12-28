// Step 2: Concrete Handlers
class LevelOneSupport extends SupportHandler {
    public void handleRequest(int issueLevel) {
        if (issueLevel <= 1) {
            System.out.println("Level 1 support handled issue");
        } else if (next != null) {
            next.handleRequest(issueLevel);
        }
    }
}

class LevelTwoSupport extends SupportHandler {
    public void handleRequest(int issueLevel) {
        if (issueLevel <= 2) {
            System.out.println("Level 2 support handled issue");
        } else if (next != null) {
            next.handleRequest(issueLevel);
        }
    }
}

class LevelThreeSupport extends SupportHandler {
    public void handleRequest(int issueLevel) {
        System.out.println("Level 3 support handled issue");
    }
}
