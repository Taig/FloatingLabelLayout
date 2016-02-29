androidBuildAar

autoScalaLibrary := false

githubProject := "floatinglabellayout"

javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "design" % "23.2.0" ::
    Nil

minSdkVersion := "7"

name := "FloatingLabelLayout"

normalizedName := "floating-label-layout"

organization := "io.taig.android"

platformTarget := "android-23"

publishArtifact in ( Compile, packageDoc ) := false

scalaVersion := "2.11.7"

scalacOptions ++=
    "-deprecation" ::
    "-feature" ::
    Nil

targetSdkVersion := "23"

typedResources := false

version := "1.1.3"