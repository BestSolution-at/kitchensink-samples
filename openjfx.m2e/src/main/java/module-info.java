module openjfx.m2e {
	requires javafx.controls;
	requires javafx.graphics;
	opens openjfx.m2e to javafx.graphics;
}