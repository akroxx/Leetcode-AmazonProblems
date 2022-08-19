class FileSystem {
    public HashMap<String, Integer> files;

    public FileSystem() {
        files = new HashMap<String, Integer>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.isEmpty() || path.equals("") || (path.equals("/") && path.length() == 1) || files.containsKey(path)){
            return false;
        }
        
        int delimiterIdx = path.lastIndexOf("/")        ;
        String parent = path.substring(0, delimiterIdx);
        if(parent.length() > 1 && !files.containsKey(parent)){
            return false;
        }

        files.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if(files.containsKey(path)){
            return files.get(path);
        }

        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */