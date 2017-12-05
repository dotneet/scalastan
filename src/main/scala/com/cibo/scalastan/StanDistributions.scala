/*
 * Copyright (c) 2017 CiBO Technologies - All Rights Reserved
 * You may use, distribute, and modify this code under the
 * terms of the BSD 3-Clause license.
 *
 * A copy of the license can be found on the root of this repository,
 * at https://github.com/cibotech/ScalaStan/blob/master/LICENSE,
 * or at https://opensource.org/licenses/BSD-3-Clause
 */

package com.cibo.scalastan

protected trait StanDistributions {

  def beta[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("beta", Seq(alpha, beta))

  def beta_binomial[
    N <: StanType: DiscreteType,
    A <: StanType: ContinuousType,
    B <: StanType: ContinuousType,
    R <: StanType
  ](
    n: StanValue[N],
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized3[N, A, B]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("beta_binomial", Seq(n, alpha, beta))

  def bernoulli[T <: StanType: ContinuousType, R <: StanType](
    theta: StanValue[T]
  )(
    implicit ev: Vectorized1[T]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("bernoulli", Seq(theta))

  def bernoulli_logit[T <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[T]
  )(
    implicit ev: Vectorized1[T]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("bernoulli_logit", Seq(alpha))

  def binomial[N <: StanType: DiscreteType, T <: StanType: ContinuousType, R <: StanType](
    n: StanValue[N],
    theta: StanValue[T]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("binomial", Seq(n, theta))

  def binomial_logit[N <: StanType: DiscreteType, T <: StanType: ContinuousType, R <: StanType](
    n: StanValue[N],
    alpha: StanValue[T]
  )(
    implicit ev: Vectorized2[N, T]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("binomial_logit", Seq(n, alpha))

  def categorical[T <: StanType: ContinuousType, R <: StanType](
    theta: StanValue[T]
  )(
    implicit ev: Vectorized1[T]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("categorical", Seq(theta))

  def categorical_logit[T <: StanType: ContinuousType, R <: StanType](
    beta: StanValue[T]
  )(
    implicit ev: Vectorized1[T]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("categorical_logit", Seq(beta))

  def cauchy[P <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    position: StanValue[P],
    scale: StanValue[S]
  )(
    implicit ev: Vectorized2[P, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("cauchy", Seq(position, scale))

  def chi_square[N <: StanType: ContinuousType, R <: StanType](
    nu: StanValue[N]
  )(
    implicit ev: Vectorized1[N]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("chi_square", Seq(nu))

  def dirichlet(alpha: StanValue[StanVector]): StanContinuousDistribution[StanVector] =
    StanContinuousDistribution("dirichlet", Seq(alpha))

  def double_exponential[M <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[M, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("double_exponential", Seq(mu, sigma))

  def exp_mod_normal[
    M <: StanType: ContinuousType,
    S <: StanType: ContinuousType,
    L <: StanType: ContinuousType,
    R <: StanType
  ](
    mu: StanValue[M],
    sigma: StanValue[S],
    lambda: StanValue[L]
  )(
    implicit ev: Vectorized3[M, S, L]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("exp_mod_normal", Seq(mu, sigma, lambda))

  def exponential[L <: StanType: ContinuousType, R <: StanType](
    lambda: StanValue[L]
  )(implicit ev: Vectorized1[L]): StanContinuousDistribution[R] = StanContinuousDistribution("exponential", Seq(lambda))

  def frechet[A <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[A, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("frechet", Seq(alpha, sigma))

  def gamma[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("gamma", Seq(alpha, beta))

  def gaussian_dlm_obs(
    f: StanValue[StanMatrix],
    g: StanValue[StanMatrix],
    v: StanValue[StanMatrix],
    w: StanValue[StanMatrix],
    m0: StanValue[StanVector],
    c0: StanValue[StanMatrix]
  ): StanContinuousDistribution[StanMatrix] = StanContinuousDistribution("gaussian_dlm_obs", Seq(f, g, v, w, m0, c0))

  def gumbel[M <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[M, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("gumbel", Seq(mu, beta))

  def hypergeometric[
    N <: StanType: DiscreteType,
    A <: StanType: ContinuousType,
    B <: StanType: ContinuousType,
    R <: StanType: DiscreteType
  ](
    n: StanValue[N],
    a: StanValue[A],
    b: StanValue[B]
  )(
    implicit ev: Vectorized3[N, A, B]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("hypergeometric", Seq(n, a, b))

  def inv_chi_square[N <: StanType: ContinuousType, R <: StanType](
    nu: StanValue[N]
  )(
    implicit ev: Vectorized1[N]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("inv_chi_square", Seq(nu))

  def inv_gamma[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("inv_gamma", Seq(alpha, beta))

  def inv_wishart[N <: StanScalarType](
    nu: StanValue[N],
    sigma: StanValue[StanMatrix]
  ): StanContinuousDistribution[StanMatrix] = StanContinuousDistribution("inv_wishart", Seq(nu, sigma))

  def lkj_corr[E <: StanScalarType](
    eta: StanValue[E]
  ): StanContinuousDistribution[StanMatrix] = StanContinuousDistribution("lkj_corr", Seq(eta))

  def lkj_cholesky[E <: StanScalarType](
    eta: StanValue[E]
  ): StanContinuousDistribution[StanMatrix] = StanContinuousDistribution("lkj_cholesky", Seq(eta))

  def logistic[M <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[M, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("logistic", Seq(mu, sigma))

  def lognormal[M <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[M, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("lognormal", Seq(mu, sigma))

  def multi_gp(sigma: StanValue[StanMatrix], w: StanValue[StanVector]): StanContinuousDistribution[StanReal] =
    StanContinuousDistribution("multi_gp", Seq(sigma, w))

  def multi_gp_cholesky(l: StanValue[StanMatrix], w: StanValue[StanVector]): StanContinuousDistribution[StanReal] =
    StanContinuousDistribution("multi_gp_cholesky", Seq(l, w))

  def multinomial[T <: StanType: ContinuousType, R <: StanType](
    theta: StanValue[T]
  )(
    implicit ev: Vectorized1[T]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("multinomial", Seq(theta))

  def multi_normal[
    M <: StanCompoundType: ContinuousType: IsVectorLikeOrArrayVectorLike,
    R <: StanType
  ](
    mu: StanValue[M],
    sigma: StanValue[StanMatrix]
  )(
    implicit ev1: IsVectorLikeOrArrayVectorLike[M],
    ev2: IsVectorLikeOrArrayVectorLike[R]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("multi_normal", Seq(mu, sigma))

  def multi_normal_cholesky[M <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    l: StanValue[StanMatrix]
  )(
    implicit ev1: IsVectorLikeOrArrayVectorLike[M],
    ev2: IsVectorLikeOrArrayVectorLike[R]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("multi_normal_cholesky", Seq(mu, l))

  def multi_normal_precision[M <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    omega: StanValue[StanMatrix]
  )(
    implicit ev1: IsVectorLikeOrArrayVectorLike[M],
    ev2: IsVectorLikeOrArrayVectorLike[R]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("multi_normal_prec", Seq(mu, omega))

  def multi_student_t[N <: StanScalarType, M <: StanVectorLike: ContinuousType, R <: StanType](
    nu: StanValue[N],
    mu: StanValue[M],
    sigma: StanValue[StanMatrix]
  )(
    implicit ev1: IsVectorLikeOrArrayVectorLike[N],
    ev2: IsVectorLikeOrArrayVectorLike[R]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("multi_student_t", Seq(nu, mu, sigma))

  def neg_binomial[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("neg_binomial", Seq(alpha, beta))

  def neg_binomial_2[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[A],
    phi: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("neg_binomial_2", Seq(mu, phi))

  def neg_binomial_2_log[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    eta: StanValue[A],
    phi: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("neg_binomial_2_log", Seq(eta, phi))

  def normal[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[A],
    sigma: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("normal", Seq(mu, sigma))

  def ordered_logistic[E <: StanScalarType](
    eta: StanValue[E],
    c: StanValue[StanVector]
  ): StanDiscreteDistributionWithoutCdf[StanInt] = StanDiscreteDistributionWithoutCdf("ordered_logistic", Seq(eta, c))

  def pareto[Y <: StanType: ContinuousType, A <: StanType: ContinuousType, R <: StanType](
    ymin: StanValue[Y],
    alpha: StanValue[A]
  )(
    implicit ev: Vectorized2[Y, A]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("pareto", Seq(ymin, alpha))

  def pareto_type_2[M <: StanType: ContinuousType, L <: StanType: ContinuousType, A <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    lambda: StanValue[L],
    alpha: StanValue[A]
  )(
    implicit ev: Vectorized3[M, L, A]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("pareto_type_2", Seq(mu, lambda, alpha))

  def poisson[L <: StanType: ContinuousType, R <: StanType](
    lambda: StanValue[L]
  )(
    implicit ev: Vectorized1[L]
  ): StanDiscreteDistributionWithCdf[R] = StanDiscreteDistributionWithCdf("poisson", Seq(lambda))

  def poisson_log[A <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A]
  )(
    implicit ev: Vectorized1[A]
  ): StanDiscreteDistributionWithoutCdf[R] = StanDiscreteDistributionWithoutCdf("poisson_log", Seq(alpha))

  def rayleigh[S <: StanType: ContinuousType, R <: StanType](
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized1[S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("rayleigh", Seq(sigma))

  def scaled_inv_chi_square[N <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    nu: StanValue[N],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[N, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("scaled_inv_chi_suqare", Seq(nu, sigma))

  def skew_normal[X <: StanType: ContinuousType, O <: StanType: ContinuousType, A <: StanType: ContinuousType, R <: StanType](
    xi: StanValue[X],
    omega: StanValue[O],
    alpha: StanValue[A]
  )(
    implicit ev: Vectorized3[X, O, A]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("skew_normal", Seq(xi, omega, alpha))

  def student_t[
    N <: StanType: ContinuousType,
    M <: StanType: ContinuousType,
    S <: StanType: ContinuousType,
    R <: StanType
  ](
    nu: StanValue[N],
    mu: StanValue[M],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized3[N, M, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("student_t", Seq(nu, mu, sigma))

  def uniform[A <: StanType: ContinuousType, B <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    beta: StanValue[B]
  )(
    implicit ev: Vectorized2[A, B]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("uniform", Seq(alpha, beta))

  // CDF functions not available
  def von_mises[M <: StanType: ContinuousType, K <: StanType: ContinuousType, R <: StanType](
    mu: StanValue[M],
    kappa: StanValue[K]
  )(
    implicit ev: Vectorized2[M, K]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("von_mises", Seq(mu, kappa))

  def weibull[A <: StanType: ContinuousType, S <: StanType: ContinuousType, R <: StanType](
    alpha: StanValue[A],
    sigma: StanValue[S]
  )(
    implicit ev: Vectorized2[A, S]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("weibull", Seq(alpha, sigma))

  def wiener[
    A <: StanType: ContinuousType,
    T <: StanType: ContinuousType,
    B <: StanType: ContinuousType,
    D <: StanType: ContinuousType,
    R <: StanType
  ](
    alpha: StanValue[A],
    tau: StanValue[T],
    beta: StanValue[B],
    delta: StanValue[D]
  )(
    implicit ev: Vectorized4[A, T, B, D]
  ): StanContinuousDistribution[R] = StanContinuousDistribution("wiener", Seq(alpha, tau, beta, delta))

  def wishart[N <: StanScalarType](
    nu: StanValue[N],
    sigma: StanValue[StanMatrix]
  ): StanContinuousDistribution[StanMatrix] = StanContinuousDistribution("wishart", Seq(nu, sigma))
}
