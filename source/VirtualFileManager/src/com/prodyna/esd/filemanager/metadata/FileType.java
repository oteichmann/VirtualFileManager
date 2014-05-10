package com.prodyna.esd.filemanager.metadata;

public enum FileType {

	UNKNOWN {
		@Override
		public boolean isImage() {
			return false;
		}
	},
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
	JPG {
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
