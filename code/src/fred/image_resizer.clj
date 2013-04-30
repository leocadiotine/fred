(ns fred.image-resizer
  (import java.io.File)
  (import javax.imageio.ImageIO))


(defn list-all-files
  "List all files on a given directory."
  [root-dir relative-dir]
  (.listFiles (File. (str root-dir relative-dir))))

(defn resize-image
  "Resizes the given image applying the given scale."
  [image-file scale]
  (let [buffered-image (ImageIO/read image-file)]
    ()))

(defn resize-dir
  "Resizes all images on a directory based on a scale."
  [root-dir relative-dir scale]
  (doseq [file (list-all-files root-dir relative-dir)]
    (resize-image file scale)))
