public class Person {
        private String name;
        private String surname;
        private String email;

        public Person(String name, String sName, String email) {
                this.name = name;
                surname = sName;
                this.email = email;
        }

        public String getName() {
                return name;
        }

        public String getSurname() {
                return surname;
        }

        public String getEmail() {
                return email;
        }
}
