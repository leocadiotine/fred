(ns fred.image-grabber
  (:require [fs.core :as fs]
            [clojure.string :as s]))

(def img-exts #{".jpg" ".png" ".gif"})

(defn is-image?
  "Returns whether the desired file corresponds to an image."
  [file]
  (let [[_ ext] (fs/split-ext file)]
    (and ext (img-exts (s/lower-case ext)))))

(defn get-images
  "Returns a list of image files on a certain folder."
  [folder]
  (filter is-image? (fs/list-dir folder)))
