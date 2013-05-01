(ns fred.core
  (:require [fred.image-grabber :as image-grabber]
            [fred.image-saver :as image-saver]
            [fred.image-resizer :as image-resizer])
  (:use seesaw.core))


(defn -main [path use-ldpi?]
  (native!)
  (invoke-later
    (-> (frame  :title    "Fred"
                :content  (flow-panel
                            :size [512 :by 700]
                            :items  [(label :icon (clojure.java.io/resource "icon.png"))
                                    (text :multi-line? true
                                          :editable? false
                                          :margin 20
                                          :font "ARIAL-BOLD-14"
                                          :text "Hello, master. I can resize images for you, if that is your wish.\nJust drag a folder and drop inside me and I'll gladly do the work!")])
                :on-close :exit)
      pack!
      show!)))
  ; (image-saver/copy-to-subdir-and-rename
  ;   (image-grabber/get-images path) path "drawable-xhdpi")

  ; (image-saver/clone-dir
  ;   path "drawable-xhdpi" "drawable-hdpi" "drawable-mdpi")

  ; (image-resizer/resize-dir path "drawable-hdpi" 0.75)
  ; (image-resizer/resize-dir path "drawable-mdpi" 0.5)

  ; (when (= use-ldpi? true)
  ;   (image-saver/clone-dir path "drawable-xhdpi" "drawable-ldpi")
  ;   (image-resizer/resize-dir path "drawable-ldpi" 0.25)))
