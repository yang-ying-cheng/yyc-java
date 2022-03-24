package enums;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/24 13:37
 */

public enum TestFourEnum {
    SECONDS {
        public long toSeconds(long d) {
            return d;
        }

        public long toMinutes(long d) {
            return d / C1;
        }

        public long toHours(long d) {
            return d / C2;
        }

        public long toDays(long d) {
            return d / C3;
        }
    },
    MINUTES {
        public long toSeconds(long d) {
            return d * C1;
        }

        public long toMinutes(long d) {
            return d;
        }

        public long toHours(long d) {
            return d / C2;
        }

        public long toDays(long d) {
            return d / C3;
        }

    },
    HOURS {
        public long toSeconds(long d) {
            return d * C2;
        }

        public long toMinutes(long d) {
            return d * C1;
        }

        public long toHours(long d) {
            return d;
        }

        public long toDays(long d) {
            return d / C3;
        }
    },
    DAY {
        public long toSeconds(long d) {
            return d * C2;
        }

        public long toMinutes(long d) {
            return d * C1;
        }

        public long toHours(long d) {
            return d * C3;
        }

        public long toDays(long d) {
            return d;
        }

    };


    // Handy constants for conversion methods
    static final long C0 = 1L;//秒
    static final long C1 = C0 * 60L;// 分钟
    static final long C2 = C1 * 60L;// 小时
    static final long C3 = C2 * 24L;// 天

    // 秒
    public long toSeconds(long a) {
        throw new AbstractMethodError();
    }

    // 分钟
    public long toMinutes(long a) {
        throw new AbstractMethodError();
    }

    // 小时
    public long toHours(long a) {
        throw new AbstractMethodError();
    }

    // 天
    public long toDays(long a) {
        throw new AbstractMethodError();
    }
}
