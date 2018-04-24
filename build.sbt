lazy val core = project.in(file("."))  
  .enablePlugins(AndroidLib)
  .settings(Settings.common)
  .settings(
    libraryDependencies ++=
      "com.android.support" % "design" % "27.1.1" ::
      Nil,
    name := "floating-label-layout",
    publishArtifact in ( Compile, packageDoc ) := false,
    resolvers += ("Google Maven" at "https://maven.google.com"),
    typedResources := false
  )

lazy val sample = project.in(file("sample/"))
  .enablePlugins(AndroidApp)
  .settings(Settings.common)
  .dependsOn(core)