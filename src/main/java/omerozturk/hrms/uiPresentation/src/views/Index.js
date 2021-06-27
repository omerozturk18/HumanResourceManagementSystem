/*eslint-disable*/
import React from "react";
import { Link } from "react-router-dom";

import IndexNavbar from "components/Navbars/IndexNavbar.js";
import Footer from "components/Footers/Footer.js";
import JobPostingList from "./JobPostingList";
import SystemUser from "./SystemUser";
import SystemUserEdit from "./SystemUserEdit";

export default function Index() {
  return (
    <>
      <IndexNavbar fixed />
      
      <section className="header relative pt-16 items-center flex h-screen max-h-300-px">
        <div className="container mx-auto items-center flex flex-wrap mt-16">
          <div className="w-full md:w-8/12 lg:w-6/12 xl:w-6/12 px-4 mt-16">
            <div className="pt-32 sm:pt-0">
              <h2 className="font-semibold text-4xl text-blueGray-600">
                Aradığınız İşi ve İşciyi Çok Hızlı Bulun
              </h2>
              <p className="mt-4 text-lg leading-relaxed text-blueGray-500">
                CVnizi hazırlayın – Binlerce işe her yerden kolaylıkla başvurun<br></br>
                İşverenler: Bir iş ilanı verin – Bir sonraki çalışanınız burada
                {/* Notus React is Free and Open Source. It does not change any of
                the CSS from{" "}
                <a
                  href="https://tailwindcss.com/?ref=creativetim"
                  className="text-blueGray-600"
                  target="_blank"
                >
                  Tailwind CSS
                </a>
                . It features multiple HTML elements and it comes with dynamic
                components for ReactJS, Vue and Angular. */}
              </p>
              <div className="mt-12">
                <a
                  href="https://www.creative-tim.com/learning-lab/tailwind/react/overview/notus?ref=nr-index"
                  target="_blank"
                  className="get-started text-white font-bold px-6 py-4 rounded outline-none focus:outline-none mr-1 mb-1 bg-lightBlue-500 active:bg-lightBlue-600 uppercase text-sm shadow hover:shadow-lg ease-linear transition-all duration-150"
                >
                  Üye Ol
                </a>
                <a
                  href="https://github.com/creativetimofficial/notus-react?ref=nr-index"
                  className="github-star ml-1 text-white font-bold px-6 py-4 rounded outline-none focus:outline-none mr-1 mb-1 bg-blueGray-700 active:bg-blueGray-600 uppercase text-sm shadow hover:shadow-lg ease-linear transition-all duration-150"
                  target="_blank"
                >
                  Giriş Yap
                </a>
              </div>
            </div>
          </div>
        </div>

        <img
          className="absolute top-0 b-auto right-0 pt-16 sm:w-6/12 -mt-48 sm:mt-0 w-10/12 max-h-100px"
          src={require("assets/img/pattern_react.png").default}
          alt="..."
        />
      </section>

      <section className="mt-48 md:mt-40 pb-40 relative bg-blueGray-100">
        <div
          className="-mt-20 top-0 bottom-auto left-0 right-0 w-full absolute h-20"
          style={{ transform: "translateZ(0)" }}
        >
          <svg
            className="absolute bottom-0 overflow-hidden"
            xmlns="http://www.w3.org/2000/svg"
            preserveAspectRatio="none"
            version="1.1"
            viewBox="0 0 2560 100"
            x="0"
            y="0"
          >
            <polygon
              className="text-blueGray-100 fill-current"
              points="2560 0 2560 100 0 100"
            ></polygon>
          </svg>
        </div>
        <div className="container-32xl px-4 mx-52">
          <div className="flex flex-wrap items-center">
            
            <JobPostingList />
          </div>



        </div>

      </section>
      <Footer />
    </>
  );
}
