class NameCollection implements Container<String> {
    private String[] names = {"Amit", "Ritik", "Neha"};

    public Iterator<String> getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext() {
            return index < names.length;
        }

        public String next() {
            return names[index++];
        }
    }
}
