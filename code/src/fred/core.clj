(ns fred.core
  (:require [fred.image-grabber :as image-grabber]
            [fred.image-saver :as image-saver]
            [fred.image-resizer :as image-resizer]
            [seesaw.dnd :as dnd])
  (:use seesaw.core))

(defn get-parent-path
  "Returns the folder immediately above of the given one."
  [path]
  (str 
      (clojure.string/join  "/"
                            (butlast (clojure.string/split path #"/")))
      "/"))

(defn resize
  "Resizes all images on the given path."
  [path-images]
  (let [path-folders (get-parent-path path-images)]
    (println path-folders)
    (image-saver/copy-to-dir-and-rename
      (image-grabber/get-images path-images) path-images (str path-folders "drawable-xhdpi/"))

    (image-saver/clone-dir
      path-folders "drawable-xhdpi" "drawable-hdpi" "drawable-mdpi")

    (image-resizer/resize-dir path-folders "drawable-hdpi" 0.75)
    (image-resizer/resize-dir path-folders "drawable-mdpi" 0.5))

  ;; TODO
  ; (when (= use-ldpi? true)
  ;   (image-saver/clone-dir path-folders "drawable-xhdpi" "drawable-ldpi")
  ;   (image-resizer/resize-dir path-folders "drawable-ldpi" 0.25))

  (alert "Your images were resized, buddy. Hope I've been useful.\nDo you want to grab a beer someday?"))

(defn handle-file-drop
  "Grabs the dropped folder and start the resizing process."
  [data]
  ;; data needs to be one folder.
  ;; TODO: support dropping multiple files.
  ;; TODO: handle exceptions
  (resize (str (.get data 0) "/")))

(defn -main [path use-ldpi?]
  (native!)
  (invoke-later
    (-> (frame  :title    "Fred"
                :content  (flow-panel
                            :size [512 :by 700]
                            :items  [(label :icon (clojure.java.io/resource "icon.png")
                                      :drag-enabled? true
                                      :transfer-handler 
                                        (dnd/default-transfer-handler
                                          :import [dnd/file-list-flavor (fn [{:keys [data]}] (handle-file-drop data))]))
                                    (text :multi-line? true
                                          :editable? false
                                          :margin 20
                                          :font "BOLD-14"
                                          :text "Hely, pal, how is it going? I can resize images for you, it's no trouble\nat all! Just drag a folder and drop inside me and I'll gladly do the work.")])
                :on-close :exit)
      pack!
      show!)))
