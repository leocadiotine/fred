(ns fred.image-grabber
	(:require [fs.core :as fs]))

(defn is-image?
	"Returns whether the desired file corresponds to an image."
	[file]
	(let [ext (last (fs/split-ext file))]
		(if (= ext nil)
			false
			(contains? #{".jpg" ".png" ".gif"} (clojure.string/lower-case ext)))))

(defn get-images
    "Returns a list of image files on a certain folder."
    [folder]
    (filter is-image? (fs/list-dir folder)))
