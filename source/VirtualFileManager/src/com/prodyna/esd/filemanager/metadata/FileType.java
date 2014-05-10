package com.prodyna.esd.filemanager.metadata;

public enum FileType {

	TXT {
		@Override
		public boolean isImage() {
			return false;
		}
	},
	PNG {
		@Override
		public boolean isImage() {
			return true;
		}
	},
	IMG {
		@Override
		public boolean isImage() {
			return true;
		}
	},
	AVI {
		@Override
		public boolean isImage() {
			return false;
		}
	};
	
	public abstract boolean isImage();	
}
