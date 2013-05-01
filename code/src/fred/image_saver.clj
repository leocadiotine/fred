(ns fred.image-saver
  (:require [fs.core :as fs]))

(defn substitute [s substitution-map]
  (reduce (fn [s [match replacement]]
            (clojure.string/replace s match replacement))
          s substitution-map))

(defn rename-droid
  "Returns a string that matches Android's resource naming requirements:
  all lowercase, replaces '-' and whitespaces with '_' and removes @2x."
  [old-name]
  (substitute (clojure.string/lower-case old-name) {" " "_"
                                                    "-" "_"
                                                    "@2x" ""}))

(defn copy-to-subdir-and-rename
  "Moves a list of files from the given path to the given subdirectory.
  Also, renames all the files to match Android's resource naming requirements:
  all lowercase, replaces '-' and whitespaces with '_' and removes @2x."
  [file-names original-path subfolder-name]
  (doseq [filename file-names]
    (fs/copy+ (str original-path filename)
      (str original-path subfolder-name "/"
        (rename-droid filename)))))

(defn clone-dir
  "Makes several copies of original-path. root is the root folder and all the other
  arguments as folders relative to it."
  [root-folder original-path & new-paths]
  (doseq [new-path new-paths]
    (fs/copy-dir (str root-folder original-path) (str root-folder new-path))))
