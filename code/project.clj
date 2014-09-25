(defproject fred "1.1.0-SNAPSHOT"
  :description "A tool to resize images to the various screen densities of Android devices."
  :dependencies[
  	[org.clojure/clojure "1.2.1"]
  	[fs "1.1.2"]
    [org.imgscalr/imgscalr-lib "4.2"]
    [seesaw "1.4.3"]]
  :main fred.core)