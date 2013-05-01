(ns fred.image-resizer
  (import java.io.File)
  (import javax.imageio.ImageIO))


(defn list-all-files
  "List all files on a given directory."
  [root-dir relative-dir]
  (.listFiles (File. (str root-dir relative-dir))))

(defn resize-image
  "Resizes the given image applying the given scale.
  This method deletes 9-patches. TODO: properly resize them."
  [image-file scale]
  (if-not (.endsWith (.getName image-file) ".9.png")
    (let [buffered-image (ImageIO/read image-file)]
      (println (.getName image-file)))
    ;; Delete the 9-patches
    (.delete image-file)))

(defn resize-dir
  "Resizes all images on a directory based on a scale."
  [root-dir relative-dir scale]
  (doseq [file (list-all-files root-dir relative-dir)]
    (resize-image file scale)))
