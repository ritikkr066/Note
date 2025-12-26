class HardDrive {
    public String read(long lba, int size) {
        System.out.println("HardDrive reading data from sector " + lba);
        return "OS_BOOT_DATA";
    }
}
