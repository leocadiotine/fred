(ns fred.image-resizer
  (import java.io.File)
  (import javax.imageio.ImageIO)
  (import org.imgscalr.Scalr)
  (import org.imgscalr.Scalr$Method)
  (import java.awt.image.BufferedImageOp))


(defn list-all-files
  "List all files on a given directory."
  [root-dir relative-dir]
  (.listFiles (File. (str root-dir relative-dir))))

(defn get-file-extension
  "Returns the file extension."
  [file]
  (let [file-name (.getName file)]
    (.substring
      file-name
      (+ (.lastIndexOf file-name ".") 1))))

(defn override-image
  "Overrides the given file with the given BufferedImage."
  [image-file buffered-image]
  (ImageIO/write buffered-image (get-file-extension image-file) image-file))

(defn resize-image
  "Resizes the given image applying the given scale.
  This method deletes 9-patches. TODO: properly resize them."
  [image-file scale]
  (if-not (.endsWith (.getName image-file) ".9.png")
    (let [buffered-image (ImageIO/read image-file)]
      (override-image image-file
                      (Scalr/resize buffered-image
                                    Scalr$Method/AUTOMATIC
                                    (int (* (.getWidth buffered-image) scale))
                                    (int (* (.getHeight buffered-image) scale))
                                    (into-array BufferedImageOp [Scalr/OP_ANTIALIAS]))))
    ;; Delete the 9-patches
    (.delete image-file)))

(defn resize-dir
  "Resizes all images on a directory based on a scale."
  [root-dir relative-dir scale]
  (doseq [file (list-all-files root-dir relative-dir)]
    (resize-image file scale)))
