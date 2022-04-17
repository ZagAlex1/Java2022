package Course2.Homeworks.HomeWork3;

import java.util.*;

class Words {

    private String name;

        Words(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Words words = (Words) o;
            return Objects.equals(name, words.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

}

