package HW2;

        public class News {
		private int NewID;
		private int CategoryID;
		private String Name;
		private String Description;
		private String Detail;
		private String Image;
		private String Date;
		private int UserID;

		public News(int newID, int categoryID, String name, String description, String detail, String image, String date,
				int userID) {
			super();
			NewID = newID;
			CategoryID = categoryID;
			Name = name;
			Description = description;
			Detail = detail;
			Image = image;
			Date = date;
			UserID = userID;
		
		}
		public int getNewID() {
			return NewID;
		}

		public void setNewID(int newID) {
			NewID = newID;
		}

		public int getCategoryID() {
			return CategoryID;
		}

		public void setCategoryID(int categoryID) {
			CategoryID = categoryID;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getDetail() {
			return Detail;
		}

		public void setDetail(String detail) {
			Detail = detail;
		}

		public String getImage() {
			return Image;
		}

		public void setImage(String image) {
			Image = image;
		}

		public String getDate() {
			return Date;
		}

		public void setDate(String date) {
			Date = date;
		}

		public int getUserID() {
			return UserID;
		}

		public void setUserID(int userID) {
			UserID = userID;
		}
       }