(ns fred.core
  (:require [fred.image-grabber :as image-grabber]
            [fred.image-saver :as image-saver]))


(defn -main [path use-ldpi?]
  (image-saver/copy-to-subdir-and-rename
    (image-grabber/get-images path) path "drawable-xhdpi")

  (image-saver/clone-dir
    path "drawable-xhdpi" "drawable-hdpi" "drawable-mdpi")

  (if use-ldpi? 
    (image-saver/clone-dir path "drawable-xhdpi" "drawable-ldpi")))