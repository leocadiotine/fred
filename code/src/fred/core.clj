(ns fred.core
  (:require [fred.image-grabber :as image-grabber]
            [fred.image-saver :as image-saver]
            [fred.image-resizer :as image-resizer]))


(defn -main [path use-ldpi?]
  (image-saver/copy-to-subdir-and-rename
    (image-grabber/get-images path) path "drawable-xhdpi")

  (image-saver/clone-dir
    path "drawable-xhdpi" "drawable-hdpi" "drawable-mdpi")

  (image-resizer/resize-dir path "drawable-hdpi" 0.75)
  (image-resizer/resize-dir path "drawable-mdpi" 0.5)

  (when (= use-ldpi? true)
    (image-saver/clone-dir path "drawable-xhdpi" "drawable-ldpi")
    (image-resizer/resize-dir path "drawable-ldpi" 0.25)))
