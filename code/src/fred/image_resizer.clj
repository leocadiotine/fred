(ns fred.image-resizer
  (:import java.io.File
           javax.imageio.ImageIO
           org.imgscalr.Scalr
           org.imgscalr.Scalr$Method
           java.awt.image.BufferedImageOp))


(defn list-all-files
  "List all files on a given directory."
  [root-dir relative-dir]
  (.listFiles (File. (str root-dir relative-dir))))

(defn get-file-extension
  "Returns the file extension."
  [file]
  (let [file-name (.getName file)]
    (subs file-name
          (inc (.lastIndexOf file-name ".")))))

(defn override-image
  "Overrides the given file with the given BufferedImage."
  [image-file buffered-image]
  (ImageIO/write buffered-image (get-file-extension image-file) image-file))

(defn resize-image
  "Resizes the given image applying the given scale.
  TODO: properly resize them."
  [image-file scale]
  (let [buffered-image (ImageIO/read image-file)]
    (override-image image-file
                    (Scalr/resize buffered-image
                                  Scalr$Method/AUTOMATIC
                                  (int (* (.getWidth buffered-image) scale))
                                  (int (* (.getHeight buffered-image) scale))
                                  (into-array BufferedImageOp [Scalr/OP_ANTIALIAS])))))

(defn resize-dir
  "Resizes all images on a directory based on a scale."
  [root-dir relative-dir scale]
  (doseq [file (list-all-files root-dir relative-dir)]
    (if (.endsWith (.getName file) ".9.png")
      (.delete image-file)
      (resize-image file scale))))
