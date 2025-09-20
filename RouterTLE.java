class Packet {
    int source, destination, timestamp;
    Packet(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet p = (Packet) o;
        return source == p.source && destination == p.destination && timestamp == p.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

class Router {
    Queue<Packet> q = new LinkedList<>();
    Map<Integer, Set<Packet>> map = new HashMap<>();
    int memoryLimit;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet pkt = new Packet(source, destination, timestamp);

        // check duplicate (same source + destination + timestamp)
        if (map.containsKey(destination) && map.get(destination).contains(pkt)) {
            return false;
        }

        // if memory full, evict oldest
        if (q.size() == memoryLimit) {
            Packet old = q.poll();
            removeFromMap(old);
        }

        q.add(pkt);
        map.computeIfAbsent(destination, k -> new HashSet<>()).add(pkt);

        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[]{};
        Packet pkt = q.poll();
        removeFromMap(pkt);
        return new int[]{pkt.source, pkt.destination, pkt.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        if (map.containsKey(destination)) {
            for (Packet pkt : map.get(destination)) {
                if (pkt.timestamp >= startTime && pkt.timestamp <= endTime) {
                    count++;
                }
            }
        }
        return count;
    }

    private void removeFromMap(Packet pkt) {
        Set<Packet> set = map.get(pkt.destination);
        if (set != null) {
            set.remove(pkt);
            if (set.isEmpty()) {
                map.remove(pkt.destination);
            }
        }
    }
}
