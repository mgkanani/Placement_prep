public static int getusubstr(String str) {
        HashSet<String> all = new HashSet<>();
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (!all.contains(str.substring(j, i + 1))) {
                    all.add(str.substring(j, i + 1));
                }
            }
        }
        return all.size();
    }