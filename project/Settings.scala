import android.Keys._
import io.taig.sbt.sonatype.SonatypeHouserulePlugin.autoImport.githubProject
import sbt._
import sbt.Keys._

object Settings {
  val common = Def.settings(
    autoScalaLibrary := false,
    githubProject := "floating-label-layout",
    javacOptions ++=
      "-source" :: "1.7" ::
      "-target" :: "1.7" ::
      "-Xlint:deprecation" ::
      Nil,
    minSdkVersion := "14",
    organization := "io.taig.android",
    platformTarget := "android-27",
    scalacOptions ++=
      "-deprecation" ::
      "-feature" ::
      Nil,
    targetSdkVersion := "27"
  )
}
