(ns fred.core
  (:require [fred.image-grabber :as image-grabber]))


(defn -main [& args]
  (print (image-grabber/get-images (first args))))
