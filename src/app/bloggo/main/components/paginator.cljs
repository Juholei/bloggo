(ns bloggo.main.components.paginator)

(defn page-link [current-page? text destination]
  [:a {:class "bg-gray-300 hover:bg-gray-400 text-gray-800 py-2 px-4"
       :href destination}
   (if current-page?
     [:b text]
     text)])

(defn paginator [current-page page-count url-fn]
  [:div.inline-flex
   (for [page-num (range 1 (inc page-count))
         :let [current-page? (= current-page page-num)]]
     ^{:key page-num}
     [page-link current-page? page-num (url-fn page-num)])])
