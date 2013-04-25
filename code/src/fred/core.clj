(ns fred.core
	(:require [fs.core :as fs])
	(:gen-class ))

(defn -main [& args]
	(fs/list-dir "."))
