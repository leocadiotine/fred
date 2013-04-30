(ns fred.image-saver
  (:require [fs.core :as fs]))

(defn rename-droid
  "Returns a string that matches Android's resource naming requirements:
  all lowercase, replaces '-' and whitespaces with '_' and removes @2x."
  [old-name]
  (clojure.string/replace 
    (clojure.string/replace 
      (clojure.string/replace 
        (clojure.string/lower-case old-name)
        " " "_")
      "-" "_")
  "@2x" ""))

(defn copy-to-subdir-and-rename
  "Moves a list of files from the given path to the given subdirectory.
  Also, renames all the files to match Android's resource naming requirements:
  all lowercase, replaces '-' and whitespaces with '_' and removes @2x."
  [file-names original-path subfolder-name]
  (for [filename file-names]
    (fs/copy+ (str original-path filename) (str original-path subfolder-name "/" (rename-droid filename)))))
