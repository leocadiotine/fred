(ns fred.core
  (:require [fred.image-grabber :as image-grabber]
            [fred.image-saver :as image-saver]))


(defn -main [& args]
  (let [path (first args)]
    (image-saver/copy-to-subdir-and-rename
      (image-grabber/get-images path) path "drawable-xhdpi")))